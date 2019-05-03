package main.java.hostel.tool;

public class TestData {

    private static TestData ourInstance = new TestData();

    private String[] employeeData = new String[]{
            "146250909,Stacey,Fairbeard",
            "868135231,Hannie,Clewlowe",
            "457477380,Fransisco,Favill",
            "322615911,Vyky,Caddick",
            "486204384,Stanislas,Fequeux",
            "126462903,Poppy,Tordiffe",
    };

    private String[] volunteerData = new String[]{
            "139635893,Susanetta,Erskin,Russia",
            "639974227,Brig,Cranna,England",
            "494723262,Joan,Waugh,USA",
            "896431404,Danika,Crocetti,Italy",
            "752010103,Baird,Peperell,Italy",
    };

    private String[] guestData = new String[]{
            "929202627,Joann,Le Bosse,jlebosse0@nyu.edu,Female,France",
            "841976411,Flemming,Phinn,fphinn1@t.co,Male,Italy",
            "809086050,Raymund,Dorwood,rdorwood2@shutterfly.com,Male,Argentina",
            "626530467,Danella,Sabater,dsabater3@ebay.co.uk,Female,Russia",
            "554774733,Peria,Wannell,pwannell4@ucla.edu,Female,Italy",
            "325409380,Bonnee,Armsby,barmsby5@pbs.org,Female,China",
            "691770553,Leicester,Spring,lspring6@businessinsider.com,Male,Indonesia",
            "020454003,Wilek,Kybert,wkybert7@t.co,Male,China",
            "175418754,Maura,Provost,mprovost8@digg.com,Female,Cambodia",
            "223889560,Nisse,Barbour,nbarbour9@indiegogo.com,Female,Philippines",
            "666024421,Zebedee,Sugden,zsugdena@zimbio.com,Male,China",
            "315922142,Roman,Van Weedenburg,rvanweedenburgb@gov.uk,Male,Italy",
            "045484069,Noah,Denford,ndenfordc@ovh.net,Male,Japan",
            "664053996,Etta,Stook,estookd@ustream.tv,Female,Poland",
    };

    private String[] activityData = new String[]{
            "hike,monday,8",
            "swimming,wednesday,12",
            "walk,thursday,12",
            "swimming,friday,9",
            "party,saturday,22"
    };

    public String[] getEmployeeData() { return employeeData; }
    public String[] getVolunteerData() { return volunteerData; }
    public String[] getGuestData() { return guestData; }
    public String[] getActivityData() { return activityData; }

    public static TestData getInstance() { return ourInstance; }


}
