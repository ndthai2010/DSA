package src.ordered_symbol_table;

import java.util.*;

@SuppressWarnings("unchecked")
public class OrderedArraySymbolTable<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] values;
    int n = 0, default_size = 100;

    // Chú ý hoàn thiện hàm dựng, khởi tạo 2 mảng keys và values
    public OrderedArraySymbolTable() {
        // TODO Auto-generated constructor stub
        keys = (Key[]) new Comparable[default_size];
        values = (Value[]) new Object[default_size];
    }

    @Override
    // Phương thức thực hiện thêm 1 phần tử vào bảng tra cứu, phần tử mới được thêm
    // vào sao
    // cho mảng keys luôn được sắp tăng dần
    public void put(Key key, Value value) {
        // TODO Auto-generated method stub
        if (binarySearch(key) != -1) {
            values[binarySearch(key)] = value;
        } else {
            keys[n] = key;
            values[n] = value;

            int k = n;
            Key checkValue = keys[n];

            while (k > 0 && checkValue.compareTo(keys[k - 1]) < 0) {
                keys[k] = keys[k - 1];
                values[k] = values[k - 1];
                k--;
            }

            keys[k] = checkValue;
            values[k] = value;
            n++;
        }

    }

    // Phương thức thực hiện tìm kiếm khóa key trên mảng keys bằng thuật toán tìm
    // kiếm nhị phân
    // kết quả trả về là chỉ số (index) của phần tử key trong mảng key
    // nếu không tìm thấy key trong mảng keys, trả lại -1
    public int binarySearch(Key key) {
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int middle = start + (end - start) / 2;
            if(keys[middle].compareTo(key) == 0){
                return middle;
            }else if(keys[middle].compareTo(key) < 0){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        return -1;
    }

    // Phương thức get, lấy ra giá trị value tương ứng với key
    // Phương thức này gọi tới phương thức binarySearch(Key key)
    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        if (binarySearch(key) != -1) {
            return values[binarySearch(key)];
        }
        return null;
    }

    @Override
    // xóa phần tử ra khỏi bảng tra cứu, dồn lại mảng sau khi xóa
    public void delete(Key key) {
        // TODO Auto-generated method stub
        if (binarySearch(key) != -1) {
            Key[] list = (Key[]) new Comparable[default_size];
            int idx = binarySearch(key);
            for (int i = 0; i < idx; i++) {
                list[i] = keys[i];
            }

            for (int i = idx + 1; i < n; i++) {
                list[i] = keys[i];
            }
            list = keys;
        }
    }

    @Override
    public boolean contains(Key key) {
        // TODO Auto-generated method stub
        return values[binarySearch(key)] != null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size() == 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (values[i] != null)
                count++;
        }
        return count;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO Auto-generated method stub
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i < n; i++) {
            if (keys[i] != null) {
                list.add(keys[i]);
            }
        }
        return list;
    }

    @Override
    public Key min() {
        // TODO Auto-generated method stub
        Key min = keys[0];
        for (int i = 0; i < n; i++) {
            if (keys[i] != null && min.compareTo(keys[i]) > 0) {
                min = keys[i];
            }
        }
        return min;
    }

    @Override
    public Key max() {
        // TODO Auto-generated method stub
        Key max = keys[0];
        for (int i = 0; i < n; i++) {
            if (keys[i] != null && max.compareTo(keys[i]) < 0) {
                max = keys[i];
            }
        }
        return max;
    }

    @Override
    public Key floor(Key key) {
        // TODO Auto-generated method stub
        Key floor = keys[0];
        for (int i = 0; i < n; i++) {
            if (keys[i] != null && floor.compareTo(keys[i]) < 0
                    && key.compareTo(keys[i]) > 0) {
                floor = keys[i];
            }
        }
        return floor;
    }

    @Override
    public Key ceiling(Key key) {
        // TODO Auto-generated method stub
        Key ceiling = max();
        for (int i = 0; i < n; i++) {
            if (keys[i] != null && keys[i].compareTo(ceiling) < 0
                    && key.compareTo(keys[i]) > 0) {
                ceiling = keys[i];
            }
        }
        return ceiling;
    }

    @Override
    public int rank(Key key) {
        // TODO Auto-generated method stub
        int i = 0;
        int j = n;

        while (i <= j) {
            int t = i + (j - i) / 2;
            int k = key.compareTo(keys[t]);
            if (k < 0) {
                j = t - 1;
            } else if (k > 0) {
                i = t + 1;
            } else {
                return t;
            }
        }
        return i;
    }

    @Override
    public Key select(int k) {
        // TODO Auto-generated method stub
        return keys[k];
    }

    @Override
    public void deleteMin() {
        // TODO Auto-generated method stub
        delete(min());
    }

    @Override
    public void deleteMax() {
        // TODO Auto-generated method stub
        delete(max());
    }

    @Override
    public int size(Key u, Key v) {
        // TODO Auto-generated method stub
        return Math.abs(binarySearch(u) - binarySearch(v));
    }

    @Override
    public Iterable<Key> keys(Key u, Key v) {
        // TODO Auto-generated method stub
        List<Key> list = new ArrayList<Key>();
        Key first = u;
        Key last = v;
        if (binarySearch(first) == -1) {
            first = ceiling(u);
        }

        if (binarySearch(last) == -1) {
            last = floor(u);
        }

        for (int i = binarySearch(first); i <= binarySearch(last); i++) {
            if (u.compareTo(keys[i]) < 0 && keys[i].compareTo(v) < 0) {
                list.add(keys[i]);
            }
        }
        return list;
    }
}
