import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class XMLHandler extends DefaultHandler {

    private static final SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private Voter voter;
    private final HashMap<Voter, Integer> voterCount;

    public XMLHandler() {
        voterCount = new HashMap<>();
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        try {
            if (qName.equals("voter") && voter == null) {
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                String name = attributes.getValue("name");
                voter = new Voter(name, birthDay);
            }else if (qName.equals("visit") && voter != null) {
                int count = voterCount.getOrDefault(voter, 0);
                voterCount.put(voter, count +1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("voter"))voter = null;
    }

    public void addSQL() throws SQLException {
        System.out.println(voterCount.size());
        for (Voter voter : voterCount.keySet()){
            int count = voterCount.get(voter);
            DBConnection.countVoter(voter.toString(), count);
        }
    }
}
