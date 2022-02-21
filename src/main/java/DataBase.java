import java.util.Map;

public class DataBase {

    public Map readingList;

        public DataBase()
        {
            DataObject d1 = new DataObject("Google","www.google.com");
            DataObject d2 = new DataObject("Yahoo","www.Yahoo.com");
            readingList.put(d1.getId(),d1);
            readingList.put(d2.getId(),d2);


        }
        public Map getList()
        {
            return readingList;
        }



}
