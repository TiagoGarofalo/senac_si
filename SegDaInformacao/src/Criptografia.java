import java.io.File;

public class Criptografia {

	public static void main(String[] args) {

File f = new File("Arquivo.txt");
if(f.exists()) {
	System.out.println("arquivo ja existe");
}else {
	System.out.println("arquivo nao existia");
}

	}

}
