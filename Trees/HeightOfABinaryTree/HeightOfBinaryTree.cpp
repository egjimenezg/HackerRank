/*The tree node has data, left child and right child 
class Node {
    int data;
    Node* left;
    Node* right;
};

*/

//O(n)
int height(Node* root) {

  int leftHeight = 0;
  int rightHeihg = 0;

  if(root == NULL){
    return 0;
  }

  if(root->left != NULL){
    leftHeight += (1+height(root->left));
  }
      
  if(root->right != NULL){
    rightHeihg += (1 + height(root->right));
  }

  return (leftHeight >= rightHeihg) ? leftHeight : rightHeihg;
}

