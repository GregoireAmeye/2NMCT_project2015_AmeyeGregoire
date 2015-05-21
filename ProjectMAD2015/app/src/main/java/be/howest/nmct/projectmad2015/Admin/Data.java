package be.howest.nmct.projectmad2015.Admin;

/**
 * Created by Gregoire on 5/05/2015.
 */
public class Data {
    public enum Locatie {
        MIDDELKERKEESCAPE("House Of Riddles",
                "51.1780032","2.7965686",
                "8430 Middelkerke","Staat nr.",
                "House of Riddles @ De Kegel X-Treme wordt het eerste Real Life Escape Room Game aan de Vlaamse kust, en opent begin april 2015 zijn deuren.\n" +
                "\n" +
                "Zoals bij de rest van onze activiteiten,willen wij met deze nieuwe attractie onze klanten een super beleving laten ervaren. Hiervoor sluiten we jou en je team van minimum 2 en maximum 6 spelers op in één van onze 3 kamers. Jullie krijgen 60 minuten om de code te breken en buiten te raken. Maar...zullen jullie er in slagen ???? We hebben 3 Escape Rooms met 2 verschillende verhalen : \"De Verdwijning\" ( 2 identieke kamers) en \"...\"",
                Categorie.ESCAPE),
        KORTRIJKKARTING("World karts",
                "50.8312832","3.2858058",
                "B-8500 Kortrijk", "Spinnerijkaai 67b",
                "Tijd voor een eerste pit-stop en een aangename kennismaking met Worldkarts in het gezellige F1 Café. Piloten in spé, volleerde snelheidsduivels en ééndagskarters kunnen zich hier laten inschrijven.\n" +
                "\n" +
                "Een stapje dichter bij de sensatie... nerveus flitsende ritsen, het scheurend geluid van velcro... in de kleedkamers maken de piloten zich klaar voor de race!",
                Categorie.SPORT),
        ERGENS("Minigolf",
                "51","5",
                "2400 Mol","Postelsesteenweg 100",
                "Minigolf ergens",
                Categorie.SPORT),
        IEPERESCAPE("The Longest Hour",
                "50.846419","2.889697",
                "8900 Ieper","Staat nr.",
                "De deur valt dicht, je bent opgesloten. Samen met je team heb je exact één uur de tijd om te ontsnappen uit dat mysterieuze huis in de Ieperse binnenstad. The Longest Hour is het allereerste 'real life escape game' van België! Een unieke en intense ervaring, voor groepen van 3 tot 6 spelers. Leeftijd speelt geen rol, teamwork des te meer!",
                Categorie.ESCAPE),
        GENTESCAPE("Escape the Freakshow",
                "51.055644","3.728671",
                "9000 Gent","Vlasmarkt 10",
                "Escape games zijn een concept van real life gaming, waarbij je in een kamer in een beperkte tijdspanne puzzels moet oplossen door samen te werken met je vrienden, collega’s of zelfs onbekenden... Enkel door de puzzels op te lossen kan je uit het kamercomplex ontsnappen binnen de voorziene 60 minuten. Onze games -vol adrenaline- kunnen gespeeld worden in teams van 2 tot 6 personen.",
                Categorie.ESCAPE),
        ANTWERPENESCAPE("Antwerp Clue",
                "51.2279543","4.4055112",
                "2000 Antwerpen","Staat nr.",
                "You are locked in a room for 60 minutes and you need to find a way to escape. There are a lot of objects, codes, hidden hints, that can help you to get out. You have to be smart and think out of the box to solve the puzzles you find. In a team you have to think together, work together and most importantly laugh together. The game is for teams of 2 to 6 people and for all ages from 16 and older. Under the age of 16, you need to be accompanied by an adult. During the event the game masters will guide you through if you get stuck. We have four different game rooms.\n" +
                "\n" +
                "What are you waiting for? The clock is ticking!",
                Categorie.ESCAPE),
        BRUSSELESCAPE("Escape Hunt Experience",
                "50.8308551","4.358102",
                "1060 Brussels","Livornostraat 13-15",
                "The Escape Hunt Experience is onvoorspelbaar, verslavend, uitdagend, educatief en vooral super spannend! Reis 100 jaar terug in de tijd en ontrafel mysteries in een Brussels setting.  Boek online op onze boekingspagina. We organiseren ook unieke bedrijfsevenementen!",
                Categorie.ESCAPE),
        UTRECHTESCAPE("Escaping",
                "52.0799692","5.0872323",
                "3521 Utrecht (NL)","Livornostraat 13-15",
                "Durven jullie de escape room aan? Laat jezelf opsluiten en probeer binnen 60 minuten te ontsnappen!",
                Categorie.ESCAPE),
        KOMENSKYDIVING("Ice Mountain - Sky diving",
                "50.7825516","3.0031064",
                "7780 Komen", "Capellestraat 16",
                "Ice Mountain is veel meer dan sneeuw alleen. Momenteel bouwen we aan een Indoor Skydiving tunnel. Een nieuwe, uitdagende activiteit voor jong en oud.\n" +
                "\n" +
                "Opening: 30 Januari 2016\n" +
                "\n" +
                "Voor updates en alle info kunt u terecht op onze facebookpagina waar regelmatig foto’s van de vooruitgang verschijnen. Of schrijf u in op onze nieuwsbrief om op de hoogte te blijven van de lancering van de Indoor Skydiving tunnel.",
                Categorie.SPORT),
        ANTWERPENESCAPE2("Out of the Box",
                "51.2300658","4.4021821",
                "2000 Antwerpen","Rijnkaai 97 (Hangar 26)",
                "We will lock you up. But there is a way to find your way out. It's all about thinking out of the box using the cues and riddles inside the room to find the code to open the door.",
                Categorie.ESCAPE),
        MOLESCAPE("Escaping",
                "51.2166871","5.1869825",
                "2400 Mol","Postelsesteenweg 100",
                "Escaping Belgium is een nieuw bedrijf dat zich zal gaan vestigen in het hoofdgebouw van Sunparks Kempense Meren in Mol, waar ook het subtropisch zwembad te vinden is. We zullen een escape room gaan uitbaten, een nieuwe rage die over komt waaien vanuit Amerika.",
                Categorie.ESCAPE),
        LASERSHOOTING("Lasershooting experience",
                "51.2166871","5.1869825",
                "2960 Sint Job in't Goor","Kattenhoflaan 87",
                "In het labyrint zorgen blacklights en lichteffecten voor de nodige sfeer en spanning. Nevelmachines zorgen voor een lichte mist welke de laserstralen zichtbaar maken waardoor het raken van het doel éénvoudiger wordt.",
                Categorie.SPORT)





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
        All("Alle Categorieen"),
        ESCAPE("Escape Games"),
        SPORT("Sport"),
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
