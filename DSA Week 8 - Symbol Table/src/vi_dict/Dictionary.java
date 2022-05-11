package src.vi_dict;

@SuppressWarnings("unchecked")
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

    // Phương thức translate(DictList vi),
    // phương thức này trả lại 1 danh sách các từ tiếng Anh tương ứng với các từ
    // tiếng Việt trong danh sách vi.
    public DictList<String> translate(DictList<String> vi) {
        DictList<String> list = new DictList<String>();
        for (int i = 0; i < vi.size(); i++) {
            String endWord = vi.get(i);
            int endIdx = -1;
            for (int j = 0; j < viList.size(); j++) {
                if (endWord.equals(viList.get(j))) {
                    endIdx = j;
                    break;
                }
            }
            list.add(enList.get(endIdx));
        }
        return list;
    }

    public static void main(String[] args) {
        String[] en = {"one", "two", "three", "four", "five"};
        String[] vi = {"mot", "hai", "ba", "bon", "nam"};

        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary(vi, en);

        DictList<String> list = new DictList<String>();
        list.add("mot");
        list.add("hai");
        list.add("ba");

        DictList<String> trans = dictionary.translate(list);

        for(int i = 0; i < trans.size(); i++) {
            System.out.println(trans.get(i).toString());
        }
    }
}
