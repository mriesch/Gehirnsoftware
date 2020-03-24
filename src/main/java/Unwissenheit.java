public class Unwissenheit {

    private String zustand;
    private String instensität;
    private String ort;
    private String zeitpunkt;
    private String umstand;
    private String lebewesen;

    public Unwissenheit(String zustand, String instensität, String ort, String zeitpunkt, String umstand, String lebewesen) {
        this.zustand = zustand;
        this.instensität = instensität;
        this.ort = ort;
        this.zeitpunkt = zeitpunkt;
        this.umstand = umstand;
        this.lebewesen = lebewesen;
    }

    public void richtigesWissen() {
        // richtiger Gedanke
        System.out.println("Gedanken an richtiges Wissen der Klasse " +
                this.getClass());
    }

    public void irrtum() {
        // irrender Gedanke
        System.out.println("Gedanken an einen Irrtum der Klasse " +
                this.getClass());
    }

    public void vorstellung() {
        // vorstellender Gedanke
        System.out.println("Gedanken an eine Vorstellung der Klasse " +
                this.getClass());
    }

    public void tiefschlaf() {
        // Tiefschlafgedanke an die nicht Existens
        System.out.println("Gedanken an Schlaf der Klasse " +
                this.getClass());
    }

    public void erinnerung() {
        // erinnerender Gedanke
        System.out.println("Gedanken an eine Erinnerung der Klasse " +
                this.getClass());
    }
}
