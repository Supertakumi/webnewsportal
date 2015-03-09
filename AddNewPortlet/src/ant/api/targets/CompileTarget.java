package ant.api.targets;

import java.io.File;

import org.apache.tools.ant.Target;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.Copy;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Path;
import org.apache.tools.ant.types.Reference;

import ant.api.tasks.CopyFiles;
import ant.api.tasks.MakeDir;
import ant.api.tasks.CompileJavaFiles;

public class CompileTarget extends Target {
	
	Task compileTask;
	Copy copyFile1;
	Copy copyFile2;
	FileSet fileSet1;
	FileSet fileSet2;
	
	public CompileTarget(String webInfClassesDir, String webInfClassesContentDir, String webInfDir, Project p, String srcDir, String destDir, boolean verbose, boolean debug, boolean optimize, boolean deprecation, boolean fork, String compiler, String sourceVersion, String targetVersion, Reference classPathRefId){
		new MakeDir(new File(webInfClassesDir));
		new MakeDir(new File(webInfClassesContentDir));
		
		compileTask = new CompileJavaFiles(p, srcDir, destDir, verbose, debug, optimize, deprecation, fork, compiler, sourceVersion, targetVersion, classPathRefId);
		compileTask.setOwningTarget(this);
		compileTask.setProject(p);
		compileTask.init();
		this.addTask(compileTask);
		
		copyFile1 = new CopyFiles(webInfClassesDir, srcDir, "**/*.properties");
		copyFile2 = new CopyFiles(webInfClassesContentDir, webInfDir,"Language-ext.properties");
		copyFile1.setOwningTarget(this);
		copyFile1.setProject(p);
		copyFile2.setOwningTarget(this);
		copyFile2.setProject(p);
		copyFile1.init();
		copyFile2.init();
		this.addTask(copyFile1);
		this.addTask(copyFile2);
		
		
	}
	public CompileTarget(String webInfClassesDir, String webInfClassesContentDir, String webInfDir, Project p, String srcDir, String destDir, boolean verbose, boolean debug, boolean optimize, boolean deprecation, boolean fork, String compiler, String sourceVersion, String targetVersion, Path classPath, String includePattern1, String includePattern2){
		new MakeDir(new File(webInfClassesDir));
		new MakeDir(new File(webInfClassesContentDir));
		
		compileTask = new CompileJavaFiles(p, srcDir, destDir, verbose, debug, optimize, deprecation, fork, compiler, sourceVersion, targetVersion, classPath);
		compileTask.setOwningTarget(this);
		compileTask.setProject(p);
		compileTask.init();		
		this.addTask(compileTask);
		
		
		copyFile1 = new CopyFiles(webInfClassesDir, srcDir, "**/*.properties");
		copyFile2 = new CopyFiles(webInfClassesContentDir, webInfDir,"Language-ext.properties");
		copyFile1.setOwningTarget(this);
		copyFile1.setProject(p);
		copyFile2.setOwningTarget(this);
		copyFile2.setProject(p);
		copyFile1.init();
		copyFile2.init();
		this.addTask(copyFile1);
		this.addTask(copyFile2);
		
	}
	
}