package ownexceptionProject;

public class TestBomba {
    public static void main(String[] args) {
        Bomba bomba = new Bomba();
        try {
            bomba.despachar(111100);
        } catch (BombaException e) {
            e.printStackTrace();
        }

        try {
            bomba.despachar(50);
        } catch (BombaException e) {
            e.printStackTrace();
        }

        try {
            bomba.despachar(0);
        } catch (BombaException e) {
            e.printStackTrace();
        }

    }
}
