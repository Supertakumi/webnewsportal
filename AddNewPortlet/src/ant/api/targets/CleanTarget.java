package ant.api.targets;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.taskdefs.Delete;

//import ant.api.tasks.DeleteDir;
//import ant.api.tasks.MakeDir;

public class CleanTarget extends Target {
	
	Delete deleteFileSet1 = new Delete();
	Delete deleteFileSet2 = new Delete();
	
	public CleanTarget(Project p, String webInfClassesDir, String buildDir, boolean includeEmptyDir, boolean quietMode, boolean failOnError, String includePattern){
		
		
		FileSet fileSet1 = new FileSet();
		FileSet fileSet2 = new FileSet();
		
		
		fileSet1.setDir(new File(webInfClassesDir));
		fileSet1.createInclude().setName(includePattern);
		//fileSet1.setDefaultexcludes(defaultexcludes);
		deleteFileSet1.addFileset(fileSet1);
		deleteFileSet1.setIncludeEmptyDirs(includeEmptyDir);
		deleteFileSet1.setQuiet(quietMode);
		deleteFileSet1.setFailOnError(failOnError);
		deleteFileSet1.setOwningTarget(this);
		deleteFileSet1.init();
		this.addTask(deleteFileSet1);
		
		
		fileSet2.setDir(new File(buildDir));
		fileSet2.createInclude().setName(includePattern);
		//fileSet1.setDefaultexcludes(defaultexcludes);
		deleteFileSet2.addFileset(fileSet2);
		deleteFileSet2.setIncludeEmptyDirs(includeEmptyDir);
		deleteFileSet2.setQuiet(quietMode);
		deleteFileSet2.setFailOnError(failOnError);
		deleteFileSet2.setOwningTarget(this);
		deleteFileSet2.init();
		this.addTask(deleteFileSet2);
		
		
	}
	
public CleanTarget(Project p, FileSet buildDirFileSet, boolean includeEmptyDirs, boolean quietMode, boolean failOnError){
				
		deleteFileSet2.setIncludeEmptyDirs(includeEmptyDirs);
		deleteFileSet2.setQuiet(quietMode);
		deleteFileSet2.setFailOnError(failOnError);
		deleteFileSet2.addFileset(buildDirFileSet);
		deleteFileSet2.setOwningTarget(this);
		deleteFileSet2.init();
		//this.addTask(deleteFileSet2);
		
	}
	
	
}
