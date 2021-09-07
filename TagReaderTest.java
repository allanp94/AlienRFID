

 /* 
 TCP/IP address:
  10.9.8.10
 
 Port number:
  23
 
 Username = alien
 Password = password
 
 Use command "q" to quit the telnet session and disconnect the session; 
 reader automatically disconnects an idle TCP/IP connection; see NetworkTimeout setting
 
 Interactive mode: 
 immediately returns a list of tags in the reader's field of view
 
 Autonomous mode: 
 the reader constantly reads tags; can initiate conversation with a network 
 when a certain condition is met a.k.a new tag
 
 NotifyAddress: 
 can send messages to a specific machine on the network over a TCP socket, email, serial port
 */


import com.alien.enterpriseRFID.reader.*;
import com.alien.enterpriseRFID.tags.*;

 
public class TagReaderTest {
     
    public TagReaderTest() throws AlienReaderException {

        AlienClass1Reader reader = new AlienClass1Reader();

        //reader.setConnection("COM1"); 

        //TCP/IP address and port number
        reader.setConnection("10.9.8.10", 23);
        reader.setUsername("alien");
        reader.setPassword("password");
        
        //open connection to the reader
        reader.open();

        long readCount = 0;
        
        for (int k = 0; k < 100; k++) {

            //read tags from reader and print them 
            Tag tagList[] = reader.getTagList();
            if (tagList == null) {
                System.out.println("no tags found");
            } else {
                ++readCount;

                System.out.println("Tag(s) found");

                for (int i = 0; i < tagList.length; i++) {
                    Tag tag = tagList[i];
                    System.out.println("ID:" + tag.getTagID());
                }
            }

        }
        
		// Close the connection
		reader.close();

    } // end TagReaderTest

    public static final void main(String[] args) {
        System.out.println("hello there");

        try {
            new TagReaderTest(); 
        } catch (AlienReaderException e) {
            System.out.println("Error: " + e.toString());
        }
    
        
    }
}