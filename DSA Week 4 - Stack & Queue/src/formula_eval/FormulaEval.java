package src.formula_eval;

public class FormulaEval {
    
    public double eval(String formula) {
        String[] data = formula.split(" ");
        StackInterface<String> stack1 = new LinkedListStack<String>();
        StackInterface<String> stack2 = new LinkedListStack<String>();

        for(int i = 0; i < data.length; i++) {
            if(data[i].matches("[+-/]") || data[i].equals("*")){ 
                stack2.push(data[i]);
            }else{
                if(!data[i].equals("(") && !data[i].equals(")")){
                    stack1.push(data[i]);
                }else{ 
                    if(data[i].equals(")")){
                        String b = stack1.pop();
                        String a = stack1.pop();
                        String o = stack2.pop();
                        String result = compute(a, b, o);
                        stack1.push(result);
                    }
                }
            }
        }
        return Double.parseDouble(stack1.pop());
    }   

    public String compute(String b, String a, String o){
        if(o.equals("+")){
            double x = Double.parseDouble(a);
            double y = Double.parseDouble(b);
            double result = x + y;
            return result + " ";
        }else if(o.equals("-")){
            double x = Double.parseDouble(a);
            double y = Double.parseDouble(b);
            double result = x - y;
            return result + " ";
        }else if(o.equals("*")){ 
            double x = Double.parseDouble(a);
            double y = Double.parseDouble(b);
            double result = x * y;
            return result + " ";
        }else if(o.equals("/")){
            double x = Double.parseDouble(a);
            double y = Double.parseDouble(b);
            double result = x / y;
            return result + " ";
        }
        return "";
    }
}
