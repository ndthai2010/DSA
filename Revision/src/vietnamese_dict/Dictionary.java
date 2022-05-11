package src.vietnamese_dict;

public class Dictionary {
    private DictList<String> viList = null; // Danh sách lưu các từ tiếng Việt
    private DictList<String> enList = null; // Danh sách lưu các từ tiếng Anh

    public Dictionary() {
        viList = new DictList<String>();
        enList = new DictList<String>();
    }

    // Phương thức loadDictionary(String[] vi, String[] en),
    // phương thức này thực hiện nạp từ điển, lưu các phần tử trong mảng vi vào danh
    // sách chứa các từ tiếng Việt,
    // và các phần từ trong mảng en vào danh sách chứa các từ tiếng Anh.
    public void loadDictionary(String[] vi, String[] en) {
        for (int i = 0; i < vi.length; i++) {
            viList.add(vi[i]);
            enList.add(en[i]);
        }
    }

    private int indexOf(String key) {
        for (int i = 0; i < viList.size(); i++) {
            if (viList.get(i).equals(key))
                return i;
        }
        return -1;
    }

    // Phương thức translate(DictList vi),
    // phương thức này trả lại 1 danh sách các từ tiếng Anh tương ứng với các từ
    // tiếng Việt trong danh sách vi.
    public DictList<String> translate(DictList<String> vi) {
        DictList<String> trans = new DictList<String>();
        for (int i = 0; i < vi.size(); i++) {
            if (indexOf(vi.get(i)) != -1) {
                trans.add(enList.get(indexOf(vi.get(i))));
            }
        }
        return trans;
    }
}
