package be.howest.nmct.projectmad2015.Admin;

/**
 * Created by Gregoire on 5/05/2015.
 */
public class Data {
    public enum Locatie {
        KOMENGREG("Greg Huis",
                "50.7871508", "3.0025363",
                "Komen", "Kapellestraat 80",
                "Grégoire Ameye woont hier", Categorie.ANDERE),
        IEPERMARKT("Ieper Markt",
                "50.850829","2.884934",
                "Ieper", "Markt",
                "Pintjes drinken", Categorie.ANDERE),
        KORTRIJKK("Kortrijk K",
                "50.8028051", "3.279785",
                "Kortrijk","K",
                "Shoppingcentrum", Categorie.ANDERE),
        IEPERESCAPE("The Longest Hour",
                "50.846419","2.889697",
                "Ieper","Staat nr.",
                "Escape game in ieper", Categorie.ESCAPE),
        GENTESCAPE("Escape the Freakshow",
                "51.055644","3.728671",
                "Gent","Staat nr.",
                "Escape game in Gent", Categorie.ESCAPE),
        ANTWERPENESCAPE("Antwerp Clue",
                "51.2279543","4.4055112",
                "Antwerpen","Staat nr.",
                "Escape game in Antwerpen", Categorie.ESCAPE),
        MIDDELKERKEESCAPE("House Of Riddles",
                "51.1780032","2.7965686",
                "Middelkerke","Staat nr.",
                "Escape game in Middelkerke", Categorie.ESCAPE),
        BRUSSELESCAPE("Escape Hunt Experience",
                "50.8308551","4.358102",
                "1060 Brussels","Livornostraat 13-15",
                "Escape game in Brussel", Categorie.ESCAPE),
        UTRECHTESCAPE("Escaping",
                "50.8308551","4.358102",
                "3521 Utrecht (NL)","Livornostraat 13-15",
                "Escape game in Brussel", Categorie.ESCAPE),





        ;


        private String naamLocatie;
        private String LatitudeLocatie;
        private String LongitudeLocatie;
        private String StadLocatie;
        private String StraatLocatie;
        private String BeschrijvingLocatie;
        private Categorie CategorieLocatie;

        Locatie(String naamLocatie, String LatitudeLocatie, String LongitudeLocatie, String StadLocatie, String StraatLocatie, String BeschrijvingLocatie, Categorie CategorieLocatie ) {
            this.naamLocatie = naamLocatie;
            this.LatitudeLocatie = LatitudeLocatie;
            this.LongitudeLocatie = LongitudeLocatie;
            this.StadLocatie = StadLocatie;
            this.StraatLocatie = StraatLocatie;
            this.BeschrijvingLocatie = BeschrijvingLocatie;
            this.CategorieLocatie = CategorieLocatie;
        }



        public String getNaamLocatie() {
            return naamLocatie;
        }

        public String getLatitudeLocatie() {
            return LatitudeLocatie;
        }

        public String getLongitudeLocatie() {
            return LongitudeLocatie;
        }

        public String getBeschrijvingLocatie() {
            return BeschrijvingLocatie;
        }

        public String getStadLocatie() {
            return StadLocatie;
        }

        public String getStraatLocatie() {
            return StraatLocatie;
        }

        public Categorie getCategorieLocatie() {
            return CategorieLocatie;
        }
    }

    public enum Categorie{
        ESCAPE("Escape Game"),
        ANDERE("Andere Categorie");

        private String Categorie;

        Categorie(String categorie) {
            Categorie = categorie;
        }

        public String getCategorie() {
            return Categorie;
        }
    }

}
