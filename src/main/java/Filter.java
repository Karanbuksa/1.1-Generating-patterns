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
        logger.log("Запускаем фильтрацию");
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i < threshold) {
                logger.log("Элемент \"" + i + "\" не проходит ");
            } else {
                logger.log("Элемент \"" + i + "\" проходит ");
                result.add(i);
            }
        }
        logger.log("Прошло фильтр" + result.size() + "элемента из" + source.size());
        logger.log("Выводим результат на экран");

        return result;
    }
}