package ant.api.tasks;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Javac;
import org.apache.tools.ant.types.Path;
import org.apache.tools.ant.types.Reference;

public class CompileJavaFiles extends Javac{
	
	
	public CompileJavaFiles(Project p, String srcDir, String destDir, String compiler, String sourceVersion, String targetVersion, Path classPath){
		this.init();
		this.setSrcdir(new Path(p, srcDir));
		this.setDestdir(new File(destDir));
		this.setCompiler(compiler);
		this.setSource(sourceVersion);
		this.setTarget(targetVersion);
		this.setClasspath(classPath);
		//this.execute();
	}
	
	public CompileJavaFiles(Project p, String srcDir, String destDir, String compiler, String sourceVersion, String targetVersion, Reference classPathRefId){
		this.init();
		this.setSrcdir(new Path(p, srcDir));
		this.setDestdir(new File(destDir));
		this.setCompiler(compiler);
		this.setSource(sourceVersion);
		this.setTarget(targetVersion);
		this.setClasspathRef(classPathRefId);
	}
	
	public CompileJavaFiles(Project p, String srcDir, String destDir, boolean verbose, boolean debug, boolean optimize, boolean deprecation, boolean fork, String compiler, String sourceVersion, String targetVersion, Path classPath){
		this.init();
		this.setSrcdir(new Path(p, srcDir));
		this.setDestdir(new File(destDir));
		this.setVerbose(verbose);
		this.setDebug(debug);
		this.setOptimize(optimize);
		this.setDeprecation(deprecation);
		this.setFork(fork);
		this.setCompiler(compiler);
		this.setSource(sourceVersion);
		this.setTarget(targetVersion);
		this.setClasspath(classPath);
	}
	
	public CompileJavaFiles(Project p, String srcDir, String destDir, boolean verbose, boolean debug, boolean optimize, boolean deprecation, boolean fork, String compiler, String sourceVersion, String targetVersion, Reference classPathRefId){
		this.init();
		this.setSrcdir(new Path(p, srcDir));
		this.setDestdir(new File(destDir));
		this.setVerbose(verbose);
		this.setDebug(debug);
		this.setOptimize(optimize);
		this.setDeprecation(deprecation);
		this.setFork(fork);
		this.setCompiler(compiler);
		this.setSource(sourceVersion);
		this.setTarget(targetVersion);
		this.setClasspathRef(classPathRefId);
	}
}
