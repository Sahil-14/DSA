void insertAtBottom(stack<Interger> s,int x){
  if(s.isEmpty()){
    s.push(x);
    return;
  }
  int top =  s.pop();
  insertAtBottom(x);
  s.push(top);
  return;
}

void reverse(Stack<Integer> s){
  if(s.isEmpty()){
 return;
  }
  int top = s.pop();
  reverse(s);
  insertAtBottom(top);
}