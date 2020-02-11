package datastructure4;

/**
 * @author: huhao
 * @time: 2020/2/10 16:00
 * @desc:
 */
public interface UF {
    int  getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
