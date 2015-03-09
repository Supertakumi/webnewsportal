package ant.api.projects;


import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

//import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
//import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.Delete;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Path;

import ant.api.targets.BuildWarTarget;
import ant.api.targets.CompileTarget;
import javaxml.code.listing.*;


public class CreatePortlet {
	
	

	/**
	 * This class creates a portlet by creating a .war file and deploying 
	 * it to the auto-deploy folder of Liferay
	 */
	public static void main(String[] args) {
		try{
			Properties properties = new Properties();
			String deployDir = "E:/Project/liferay-portal-6.1.0-ce-ga1/deploy";
			String baseDir = "E:/Project/Eclipse/Workspace/Experiments";
			//String baseDir = "F:/Eclipse/Workspace/AddNewPortlet";
			//String baseDir = ".";
			
			String warFileName = "AddPortlet";
			
			if(baseDir.equals("E:/Project/Eclipse/Workspace/Experiments")){
			properties.load(new FileInputStream (new File(baseDir, "WEB-INF/Language-ext.properties")));
			warFileName = properties.getProperty("javax.portlet.title");
			warFileName = warFileName.replace(" ", "_");
			}
			
			if(baseDir.equals("E:/Project/Eclipse/Workspace/AddNewPortlet")){
				warFileName = "AddPortlet";
			}
			
			String [] args0 = new String[] {""};
			LifeRayPortletXml.main(args0);
			PortletXml.main(args0);
			WebXml.main(args0);
			LifeRayDisplayXml.main(args0);
			
			
			Project createPortlet = new Project();
			createPortlet.setName("CreatePortlet");
			createPortlet.setDefault("build");
			createPortlet.setBaseDir(new File(baseDir));
			createPortlet.init();
			
			
			/*DefaultLogger consoleLogger = new DefaultLogger();
			consoleLogger.setErrorPrintStream(System.err);
			consoleLogger.setOutputPrintStream(System.out);
			consoleLogger.setMessageOutputLevel(Project.MSG_INFO);
			createPortlet.addBuildListener(consoleLogger);*/
			
			
			//Defining project properties
			createPortlet.setProperty("compiler", "modern");
			String compiler = createPortlet.getProperty("compiler");
			boolean verbose = true;
			boolean debug = true;
			boolean optimize = true;
			boolean deprecation = true;
			boolean fork = true;
			
			createPortlet.setProperty("target", "1.5");
			String targetVersion = createPortlet.getProperty("target");
			
			createPortlet.setProperty("source", "1.5");
			String sourceVersion = createPortlet.getProperty("source");
			
			
			
			//Defining properties to refer to directories in the project
			createPortlet.setProperty("webinf.dir",baseDir + "/WEB-INF");
			String webInfDir = createPortlet.getProperty("webinf.dir");
			
			createPortlet.setProperty("webinf.lib.dir",baseDir + "/WEB-INF/lib");
			String webInfLibDir = createPortlet.getProperty("webinf.lib.dir");
			
			createPortlet.setProperty("lib.dir",baseDir + "/lib");
			String libDir = createPortlet.getProperty("lib.dir");
			
			createPortlet.setProperty("src.dir",baseDir + "/src");
			String srcDir = createPortlet.getProperty("src.dir");
			
			createPortlet.setProperty("build.dir",baseDir + "/build");
			String buildDir = createPortlet.getProperty("build.dir");
			
			createPortlet.setProperty("warfile",baseDir + "/build/" +warFileName+ ".war");
			String destFile = createPortlet.getProperty("warfile");
			
			createPortlet.setProperty("webinf.classes.dir",baseDir + "/WEB-INF/classes");
			String webInfClassesDir = createPortlet.getProperty("webinf.classes.dir");
			
			createPortlet.setProperty("webinf.classes.content.dir",baseDir + "/WEB-INF/classes/content");
			String webInfClassesContentDir = createPortlet.getProperty("webinf.classes.content.dir");
			
			createPortlet.setProperty("web.xml",baseDir + "/WEB-INF/web.xml");
			String webXml = createPortlet.getProperty("web.xml");
			
			
			//Defining the file set used for the web application
			FileSet webAppFileSet = new FileSet();
			webAppFileSet.setDir(new File(webInfLibDir));
			webAppFileSet.setIncludes("*.jar");
			
			//Defining the file set of libraries to be used
			FileSet libFileSet = new FileSet();
			libFileSet.setDir(new File(libDir));
			libFileSet.setIncludes("*.jar");
			
			//Defining the file set for WEB-INF classes directory
			FileSet webInfClassesFileSet = new FileSet();
			webInfClassesFileSet.setDir(new File(webInfClassesDir));
			webInfClassesFileSet.setIncludes("**/*");
			
			//Defining the file set for build directory
			FileSet buildDirFileSet = new FileSet();
			buildDirFileSet.setDir(new File(buildDir));
			
			//Defining the class path which includes necessary classes and libraries
			Path classPath = new Path(createPortlet);
			classPath.setPath(webInfClassesDir);
			classPath.addFileset(webAppFileSet);
			classPath.addFileset(libFileSet);
			
			//Defining the file set for the .war file
			FileSet warFileSet = new FileSet();
			warFileSet.setDir(new File(baseDir));
			warFileSet.setIncludes("WEB-INF/**");
			warFileSet.setIncludes("images/**");
			warFileSet.setIncludes("js/**");
			warFileSet.setIncludes("css/**");
			warFileSet.setExcludes("WEB-INF/Language-ext.properties");
			warFileSet.setExcludes(webXml);
			
			//Compile target to compile the sources
			Target compileTarget = new CompileTarget(webInfClassesDir,webInfClassesContentDir, webInfDir, createPortlet, srcDir, webInfClassesDir, verbose, debug, optimize, deprecation, fork, compiler, sourceVersion, targetVersion, classPath,"**/*.properties","Language-ext.properties");
			compileTarget.setName("compile");
			createPortlet.addTarget("compile", compileTarget);
			
			//Clean target to clean up all files and directories
			//Target cleanTarget = new CleanTarget(createPortlet, webInfClassesFileSet, true, true, false);
			//cleanTarget.setName("clean");
			//createPortlet.addTarget("clean",cleanTarget);
			
			Target cleanTarget1 = new Target();
			cleanTarget1.setName("clean1");
			Delete delete1 = new Delete();
			delete1.addFileset(webInfClassesFileSet);
			delete1.setIncludeEmptyDirs(true);
			delete1.setQuiet(false);
			delete1.setOwningTarget(cleanTarget1);
			delete1.setProject(createPortlet);
			delete1.init();
			cleanTarget1.addTask(delete1);
			createPortlet.addTarget("clean1",cleanTarget1);
			
			Target cleanTarget2 = new Target();
			cleanTarget2.setName("clean2");
			Delete delete2 = new Delete();
			delete2.addFileset(webInfClassesFileSet);
			delete2.setIncludeEmptyDirs(true);
			delete2.setQuiet(false);
			delete2.setOwningTarget(cleanTarget2);
			delete2.setProject(createPortlet);
			delete2.init();
			cleanTarget2.addTask(delete2);
			createPortlet.addTarget("clean2",cleanTarget2);
			
			
			
			
			//Build target to create .war file
			Target buildWarTarget = new BuildWarTarget(createPortlet, buildDir, destFile, webXml, warFileSet , deployDir, "**/*.war");
			buildWarTarget.setName("build");
			buildWarTarget.addDependency("clean1");
			buildWarTarget.addDependency("clean2");
			buildWarTarget.addDependency("compile");
			createPortlet.addTarget("build", buildWarTarget);
			
			createPortlet.executeTarget(createPortlet.getDefaultTarget());
			
		}
		catch (Exception e){
			System.err.println("Following went wrong...");
			e.printStackTrace();
		}

	}

}
