package ant.api.targets;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.types.FileSet;
//import org.apache.tools.ant.types.Reference;

import ant.api.tasks.CopyFiles;
import ant.api.tasks.MakeDir;
import ant.api.tasks.BuildWar;


public class BuildWarTarget extends Target {
	
	BuildWar buildWarTask;
	CopyFiles copyFiles;
	
	public BuildWarTarget(Project p, String buildDir, String destFile, String webXml, FileSet warFileSet, String deployDir, String includePattern){
		new MakeDir(new File(buildDir));
		
		buildWarTask = new BuildWar(destFile, webXml, warFileSet);
		buildWarTask.setOwningTarget(this);
		buildWarTask.setProject(p);
		buildWarTask.init();
		this.addTask(buildWarTask);
		
		copyFiles = new CopyFiles(deployDir, buildDir, includePattern);
		copyFiles.setOwningTarget(this);
		copyFiles.setProject(p);
		copyFiles.init();
		this.addTask(copyFiles);
	}
}
