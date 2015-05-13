package be.howest.nmct.projectmad2015.Admin;

/**
 * Created by Gregoire on 5/05/2015.
 */
public class Data {
    public enum Locatie {
        KOMENGREG("Greg Huis",
                "50.7871508", "3.0025363",
                "7780 Komen", "Kapellestraat 80",
                "Grégoire Ameye woont hier", Categorie.ANDERE),
        IEPERMARKT("Ieper Markt",
                "50.850829","2.884934",
                "8900 Ieper", "Markt",
                "Pintjes drinken", Categorie.ANDERE),
        KORTRIJKK("Kortrijk K",
                "50.8028051", "3.279785",
                "8500 Kortrijk","K",
                "Shoppingcentrum", Categorie.ANDERE),
        IEPERESCAPE("The Longest Hour",
                "50.846419","2.889697",
                "8900 Ieper","Staat nr.",
                "Escape game in ieper", Categorie.ESCAPE),
        GENTESCAPE("Escape the Freakshow",
                "51.055644","3.728671",
                "9000 Gent","Vlasmarkt 10",
                "Escape game in Gent", Categorie.ESCAPE),
        ANTWERPENESCAPE("Antwerp Clue",
                "51.2279543","4.4055112",
                "2000 Antwerpen","Staat nr.",
                "Escape game in Antwerpen", Categorie.ESCAPE),
        MIDDELKERKEESCAPE("House Of Riddles",
                "51.1780032","2.7965686",
                "8430 Middelkerke","Staat nr.",
                "Escape game in Middelkerke", Categorie.ESCAPE),
        BRUSSELESCAPE("Escape Hunt Experience",
                "50.8308551","4.358102",
                "1060 Brussels","Livornostraat 13-15",
                "Escape game in Brussel", Categorie.ESCAPE),
        UTRECHTESCAPE("Escaping",
                "52.0799692","5.0872323",
                "3521 Utrecht (NL)","Livornostraat 13-15",
                "Escape game in Brussel", Categorie.ESCAPE),
        ANTWERPENESCAPE2("Out of the Box",
                "51.2300658","4.4021821",
                "2000 Antwerpen","Rijnkaai 97 (Hangar 26)",
                "Escape game in Antwerpen", Categorie.ESCAPE),
        MOLESCAPE("Escaping",
                "51.2166871","5.1869825",
                "2400 Mol","Postelsesteenweg 100",
                "Escape game in Mol (sunparks)", Categorie.ESCAPE)





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
