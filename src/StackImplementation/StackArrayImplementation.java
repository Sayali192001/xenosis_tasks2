package StackImplementation;

public class StackArrayImplementation {

    int stack[]=new int[5];
    int top=0;

    public void push(int data)
    {
        if (top==5){
            System.out.println("Stack is full");
        }
        else {
            stack[top] = data;
            top++;
        }
    }

    public int pop()
    {
        int data=0;
        if (isEmpty()){
            System.out.println("Stack is Empty");
        }
        else {

            top--;
            data = stack[top];
            stack[top] = 0;
        }
        return data;

    }
    public int peek()
    {
        int data;
        data=stack[top-1];
        return data;
    }
    public int size()
    {
        return top;                     //it will return the number of elements present in the stack
    }

    public boolean isEmpty()
    {
        return top<=0;
    }

    public void show(){
        for (int n : stack)
        {
            System.out.println(n+" ");
        }
    }

    public static void main(String[] args) {
        StackArrayImplementation stackarr=new StackArrayImplementation();
        stackarr.push(15);
        stackarr.push(10);
        stackarr.push(20);
        stackarr.push(23);
        stackarr.push(17);
        stackarr.show();


        stackarr.pop();
        stackarr.show();
        System.out.println("Size of stack is="+stackarr.size());
    }
}
