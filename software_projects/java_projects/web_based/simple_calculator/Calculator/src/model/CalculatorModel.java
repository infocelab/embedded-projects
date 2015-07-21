/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author ahza
 */
public class CalculatorModel {
    int operator=0;
    double operand1;
    double operand2;
    double result;

    public void setOperand(String opr) {
        if(!opr.equals("")){
            if(operator==0){
                operand1=Double.valueOf(opr);
            }else{
                operand2=Double.valueOf(opr);
            }
        }
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double hasil) {
        this.result = hasil;
    }
   
    public void process(){
        switch (operator){
            case 1:
                result = operand1 + operand2;
                break;
            case 2:
                result = operand1 - operand2;
                break;
            case 3:
                result = operand1 * operand2;
                break;
            case 4:
                result = operand1 / operand2;
                break;
            case 5:
                result = operand1 % operand2;
                break;
            case 6:
                result = 1/operand1;
                break;
        }
        operand1=result;
    }

}
