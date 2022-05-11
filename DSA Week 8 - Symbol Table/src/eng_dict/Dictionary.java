package src.eng_dict;

@SuppressWarnings("unchecked")
public class Dictionary {
    private DictList<String> enList = null; // Danh sách lưu các từ tiếng Anh
    private DictList<String> viList = null; // Danh sách lưu các từ tiếng Việt

    public Dictionary(){
        enList = new DictList<String>();
        viList = new DictList<String>();
    }

    // Phương thức loadDictionary(String[] en, String[] vi), phương thức này thực
    // hiện nạp từ điển,
    // lưu các phần tử trong mảng en vào danh sách chứa các từ tiếng Anh,
    // và các phần từ trong mảng vi vào danh sách chứa các từ tiếng Việt.
    public void loadDictionary(String[] en, String[] vi) {
        for(int i = 0; i < en.length; i++) {
            enList.add(en[i]);
            viList.add(vi[i]);
        }
    }

    private int indexOf(String key){
        for(int i = 0; i < enList.size(); i++) {
            if(enList.get(i).equals(key)){
                return i;
            }
        }
        return -1;
    }

    // Phương thức translate(DictList en),
    // phương thức này trả lại 1 danh sách các từ tiếng Việt tương ứng với các từ
    // trong danh sách en.

    public DictList<String> translate(DictList<String> en)
	{
        DictList<String> list = new DictList<>();
        for(int i = 0; i < en.size(); i++){
            if(indexOf(en.get(i)) != -1){
                list.add(viList.get(indexOf(en.get(i))));
            }
        }
		return list;
	}

}