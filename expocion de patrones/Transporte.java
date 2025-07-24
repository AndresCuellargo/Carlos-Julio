// 1️⃣ Interfaz Transporte
interface Transporte {
    void entregarBoleto();
}

// 2️⃣ Productos concretos
class Bus implements Transporte {
    public void entregarBoleto() {
        System.out.println("Boleto de autobús emitido.");
    }
}

class Avion implements Transporte {
    public void entregarBoleto() {
        System.out.println("Boleto de avión emitido.");
    }
}

// 3️⃣ Fábrica con Factory Method
class TransporteFactory {
    public static Transporte crearTransporte(String tipo) {
        if (tipo.equalsIgnoreCase("bus")) {
            return new Bus();
        } else if (tipo.equalsIgnoreCase("avion")) {
            return new Avion();
        } else {
            System.out.println("Transporte no disponible.");
            return null;
        }
    }
}

// 4️⃣ Cliente
public class Main {
    public static void main(String[] args) {
        Transporte t1 = TransporteFactory.crearTransporte("bus");
        if (t1 != null) t1.entregarBoleto();

        Transporte t2 = TransporteFactory.crearTransporte("avion");
        if (t2 != null) t2.entregarBoleto();
    }
}
