package synchronizedd;

class Printer {
    public void printDocument(String documentName) {
        synchronized (this) {
            System.out.println("Printing document: " + documentName + " by " + Thread.currentThread().getName());
            try {
            
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished printing document: " + documentName + " by " + Thread.currentThread().getName());
        }
    }
}

class DocumentPrinter implements Runnable {
    private Printer printer;
    private String documentName;

    public DocumentPrinter(Printer printer, String documentName) {
        this.printer = printer;
        this.documentName = documentName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            printer.printDocument(documentName + " - " + (i + 1));
        }
    }
}

public class Synchronized {
    public static void main(String[] args) {
        Printer sharedPrinter = new Printer();

        Thread thread1 = new Thread(new DocumentPrinter(sharedPrinter, "Document1"));
        Thread thread2 = new Thread(new DocumentPrinter(sharedPrinter, "Document2"));
        Thread thread3 = new Thread(new DocumentPrinter(sharedPrinter, "Document3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
