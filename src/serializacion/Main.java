package serializacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args)  {
		ArrayList<Empleado> empresa = new ArrayList<Empleado>();
		
		Empleado e1 = new Empleado("Fernando Simon", 57, 62200);
		e1.setClave("ElAlmendaras");
		Empleado e2 = new Empleado("Salvado Illa", 52, 75000);
		e2.setClave("Elc0ns3jer0.");
		
		empresa.add(e1);
		empresa.add(e2);
		
		File archivo = new File("Empleados");
		
		// Escribimos en el archivo.
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(empresa);
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero.");
		} catch (IOException e) {
			System.out.println("Se ha producido algún error.");
		}
		
		// Leemos el archivo.
		ArrayList<Empleado> empresa2 = new ArrayList<Empleado>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
			empresa2 = (ArrayList<Empleado>) ois.readObject();
			ois.close();
		} catch (IOException e3) {
			System.out.println("Se ha producido algún error.");
		} catch (ClassNotFoundException e3) {
			System.out.println("No se ha encontrado ningúna clase que haga referncia.");
		}
		
		System.out.println("Hay un total de " + empresa2.size() + " de empleados");
		for(Empleado e: empresa2) {
			System.out.println(e);
		}
	}

}
