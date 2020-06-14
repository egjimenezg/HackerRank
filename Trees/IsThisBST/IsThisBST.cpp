/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node struct is defined as follows:
	struct Node {
		int data;
		Node* left;
		Node* right;
	}
*/

bool isBSTValid(Node* node,Node* lower,Node* upper){
  if(node == NULL)
    return true;
      
  if(lower == NULL){
    if(node->data >= upper->data)
      return false;
      
    return (isBSTValid(node->left,NULL,node) && isBSTValid(node->right,node,upper));
  }
    
  if(upper == NULL){
    if(node->data <= lower->data)
      return false;
      
    return (isBSTValid(node->left,lower,node) && isBSTValid(node->right,node,NULL));
  }

  if((node->data > lower->data) && (node->data < upper->data)){
    return isBSTValid(node->left,lower,node) &&  isBSTValid(node->right,node,upper);
  }
      
  return false;
}

bool checkBST(Node* root) {
  return (isBSTValid(root->left,NULL,root) && isBSTValid(root->right,root,NULL));
}
