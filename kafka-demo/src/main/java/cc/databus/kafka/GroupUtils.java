package cc.databus.kafka;

public class GroupUtils {
    public static int groupSize(int listSize, int batchSize){
        if(listSize == 0 || batchSize == 0){
            return batchSize;
        }
        int tmpGroupSize = (listSize + batchSize - 1) / batchSize;
        if(tmpGroupSize == 0){
            tmpGroupSize = 1;
        }
        int slideSize = listSize / (tmpGroupSize);
        int groupSize1 = (listSize + slideSize - 1) / slideSize;
        int groupSize2 = (listSize + batchSize - 1) / batchSize;
        if(groupSize1 != groupSize2){
            slideSize = batchSize;
        }
        return slideSize;
    }

    public static void main(String[] args) {
        System.out.println(groupSize(1000, 5));
    }
}

