package fuckleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/2/5 14:05
 * @desc:
 */
public class PacalsTrangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pt = new ArrayList<List<Integer>>();


        for(int i=0; i<numRows; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j=0; j<i+1; j++){
                if(j == 0 || j == i){
                    row.add(j, 1);
                }else{
                    row.add(pt.get(i-1).get(j-1) + pt.get(i-1).get(j));
                }
            }
            pt.add(row);
        }

        return pt;
    }

    public static void main(String[] args) {
        PacalsTrangle p = new PacalsTrangle();

        p.generate(5);
    }
}
