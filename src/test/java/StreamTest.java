import ru.streamframework.controllers.IntegerStreamController;
import ru.streamframework.controllers.StringStreamController;
import ru.streamframework.core.StreamImpl;

/**
 * Created by Stukolov on 29.07.2018.
 */
public class StreamTest {
    public static void main(String[] args) {


        StringStreamController stringStreamController = new StringStreamController();
        stringStreamController.setId("myController::");

        StreamImpl myStream = new StreamImpl(stringStreamController);
        myStream.start().proccess().stop();
        myStream.clear();


        IntegerStreamController integerStreamController = new IntegerStreamController();
        integerStreamController.setId(6);
        StreamImpl integerStream = new StreamImpl(integerStreamController);
        integerStream.start().proccess().stop();



    }
}
