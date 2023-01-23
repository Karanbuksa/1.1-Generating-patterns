import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator = source.iterator();
        logger.log("��������� ����������");
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i < threshold) {
                logger.log("������� \"" + i + "\" �� �������� ");
            } else {
                logger.log("������� \"" + i + "\" �������� ");
                result.add(i);
            }
        }
        logger.log("������ ������" + result.size() + "�������� ��" + source.size());
        logger.log("������� ��������� �� �����");

        return result;
    }
}