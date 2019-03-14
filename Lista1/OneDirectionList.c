#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>

typedef struct Element
{
    int val;
    struct Element * next;
} Element_t;



void showList(Element_t * head)
{
 struct Element *help = head; 
	
   while(help != NULL){                   
        printf("%d ",help->val);          
        help=help->next;                  
}
}


int counterMTF=0;
int counterTrans=0;
int deleteValue = 0;





void insert(Element_t ** head,int val){
    struct Element *beginList = head;
    struct Element *newElement = malloc(sizeof(struct Element));  
    newElement->val = val;                                        
    if(beginList != NULL){                  
        struct Element *help = beginList;    
        while(help != NULL){                
            if(help->next == NULL){          
                help->next = newElement;    
                newElement->next = NULL;     
            }
            help = help->next;               
        }
    }
    else{                            
        beginList = newElement;     
        beginList->next = NULL;      
    }
}





void deleteVal(Element_t * beginList,int val){
 if(beginList != NULL && beginList->next !=NULL){
 struct Element *help = beginList;
 struct Element *help2 = beginList->next;

	if(help->val == val){
	 beginList = beginList->next;
        free(help); 
	deleteValue++;
}
	else{
 	while(help2 != NULL){
	if(help2->val == val)    {         	         
        free(help2);
	help->next = help2->next;
	deleteValue++;

}
      help = help->next;
      help2 = help2->next;
    }
}
}
}


void deleteMax(Element_t * beginList){
 if(beginList != NULL){
 struct Element *help = beginList;
 struct Element *toRemove;
 struct Element *previous;
	int max = help->val;
	toRemove=help;

	while(help->next != NULL){
	
	if(help->next->val > max){
	
max = help->next->val;	
	toRemove=help->next;
	previous = help;
	}
help = help->next;
	}	
	previous->next = toRemove->next;
	free(toRemove);
	
	
}
}

bool isEmpty(Element_t * beginList){   
if (beginList == NULL)
return true;
else return false;
}



void findTRANS(Element_t * beginList,int val){
	
if(beginList != NULL){


 struct Element *help = beginList;
 struct Element *help2 = beginList->next;

while(help2!=NULL){
	while(help2!=NULL){
	if(help->val == val){
	
	counterTrans++;
	help->val = help2->val;
	help2->val = val;
	help = help->next;
	help2 = help2->next;
	break;
	}
	
	help=help->next;
	help2=help2->next;

}

}}}



void deleteLast(Element_t * beginList){

 struct Element *help = beginList;
struct Element *help2 = beginList->next;

	while(help2->next!=NULL){

		help=help->next;
		help2=help2->next;
}		help->next = NULL;
		free(help2);
}






void findMTF(Element_t * beginList,int val){

 struct Element *help = beginList;
 struct Element *help2 = beginList->next;
while(help2!=NULL){
	if(help->val == val){
	help->val = help2->val;
	help2->val = val;
	//counterMTF++;
	}
	counterMTF++;
	help=help->next;
	help2=help2->next;

}
}
int findMax(Element_t * beginList){
 struct Element *help = beginList;
	int max = help->val;
	while(help!=NULL){
	if(help->val>max){
	max= help->val;
	
	}
	help=help->next;
}
	return max;

}



void randomize(int arraysize, Element_t * beginList){

srand(time(NULL));   
int arg1;
int arg2;

for(int a=0; a<10000; a++){
 Element_t * curr=beginList;
 Element_t * curr2=beginList;



arg1 = rand() % arraysize;
arg2 = rand() % arraysize;

  for(int i=0;i<arg1;i++)
	curr=curr->next;
  for(int i=0;i<arg2;i++)
	curr2=curr2->next;

	int currVal = curr->val;
	curr->val = curr2->val;
	curr2->val = currVal;
	}
}



int main()
{
    Element_t * head = NULL;
    head = malloc(sizeof(Element_t));

	
	for(int i=1; i<100; i++)
	insert(head,i);
	randomize(100,head);
	

    return 0;
}
