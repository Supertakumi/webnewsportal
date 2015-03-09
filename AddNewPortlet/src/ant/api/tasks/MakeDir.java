package ant.api.tasks;

import java.io.File;

import org.apache.tools.ant.taskdefs.Mkdir;

public class MakeDir {
	Mkdir makeDir = new Mkdir();
	public MakeDir(File dir){
		makeDir.setDir(dir);
		makeDir.execute();
	}
}
