#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ELEMENT 200

// =================구조체정의========================= //

typedef struct TreeNode {
    int weight;              // 빈도수
    char name[10];           // 문자이름
    struct TreeNode* left;   
    struct TreeNode* right;  
} TreeNode;

typedef struct {
    TreeNode* ptree; // 트리 노드의 주소
    int key;         // 최소 힙 비교 기준 (weight)
} element;

typedef struct {
    element heap[MAX_ELEMENT];
    int heap_size;
} HeapType;

// =================최소히프(교재352p참조)========================= //

HeapType* create() {
    return (HeapType*)malloc(sizeof(HeapType));
}

void init(HeapType* h) {
    h->heap_size = 0;
}

void insert_min_heap(HeapType* h, element item) {
    int i = ++(h->heap_size);
    while ((i != 1) && (item.key < h->heap[i / 2].key)) {
        h->heap[i] = h->heap[i / 2];
        i /= 2;
    }
    h->heap[i] = item;
}

element delete_min_heap(HeapType* h) {
    int parent = 1, child = 2;
    element item = h->heap[1];
    element temp = h->heap[(h->heap_size)--];

    while (child <= h->heap_size) {
        if ((child < h->heap_size) && (h->heap[child].key > h->heap[child + 1].key)) {
            child++;
        }
        if (temp.key <= h->heap[child].key) break;

        h->heap[parent] = h->heap[child];
        parent = child;
        child *= 2;
    }
    h->heap[parent] = temp;
    return item;
}

// ===============이진트리함수(교재 352p참조)=========================== //

TreeNode* make_tree(TreeNode* left, TreeNode* right, const char* name, int weight) {
    TreeNode* node = (TreeNode*)malloc(sizeof(TreeNode));
    node->left = left;
    node->right = right;
    node->weight = weight;
    strcpy(node->name, name);
    return node;
}

int is_leaf(TreeNode* root) {
    return !(root->left) && !(root->right);
}

void destroy_tree(TreeNode* root) {
    if (root == NULL) return;
    destroy_tree(root->left);
    destroy_tree(root->right);
    free(root);
}

// =================전위순회(교재275p 참조)========================= //

void preorder(TreeNode* root) {
    if (root != NULL) {
        printf("%s ", root->name);
        preorder(root->left);
        preorder(root->right);
    }
}

// =================허프만코드========================= //

// 교재와 동일한 print_codes 함수 (허프만 비트 수 계산 누적 포함)
void print_codes(TreeNode* root, int codes[], int top, int* huffman_total_bits) {
    if (root->left) {
        codes[top] = 0;
        print_codes(root->left, codes, top + 1, huffman_total_bits);
    }
    if (root->right) {
        codes[top] = 1;
        print_codes(root->right, codes, top + 1, huffman_total_bits);
    }
    if (is_leaf(root)) {
        printf("%s: ", root->name);
        for (int i = 0; i < top; i++) {
            printf("%d", codes[i]);
        }
        printf("\n");
        *huffman_total_bits += (root->weight * top);
    }
}

// 고정비트 길이계산 하기
int fixed_bit(int n) {
    int bits = 0;
    int value = 1;
    while (value < n) {
        value *= 2;
        bits++;
    }
    return bits;
}

// =================인코딩+디코딩 파트========================= //

// 문자 찾아 들어가며 비트 찾는함수
int search_encode(TreeNode* root, char ch, char* code_str, int top) {
    if (root == NULL) return 0;

    if (is_leaf(root)) {
        if (root->name[0] == ch) {
            code_str[top] = '\0'; // 문자찾음
            return 1;
        }
        return 0;
    }

    code_str[top] = '0'; //0일때 if문
    if (search_encode(root->left, ch, code_str, top + 1)) return 1;

    code_str[top] = '1'; //1일때 if문
    if (search_encode(root->right, ch, code_str, top + 1)) return 1;

    return 0;
}

// 인코딩은?: 문자열 -> 0,1 되는것
void encode_string(TreeNode* root, const char* input, char* output) {
    char temp_code[100];
    output[0] = '\0';

    for (int i = 0; input[i] != '\0'; i++) {
        if (search_encode(root, input[i], temp_code, 0)) {
            strcat(output, temp_code);
        }
    }
}

// 디코딩은?: 0,1 -> 문자열 되는것
void decode_string(TreeNode* root, const char* input, char* output) {
    TreeNode* current = root;
    int out_idx = 0;

    for (int i = 0; input[i] != '\0'; i++) {
        if (input[i] == '0') {
            current = current->left;
        }
        else if (input[i] == '1') {
            current = current->right;
        }

        if (is_leaf(current)) {
            output[out_idx++] = current->name[0];
            current = root; // 다시 루트 노드로 이동
        }
    }
    output[out_idx] = '\0';
}

// =================허프만 트리생성========================= //

TreeNode* huffman_tree(HeapType* heap, int n) {
    int h_count = 1;

    for (int i = 1; i < n; i++) {
        element e1 = delete_min_heap(heap);
        element e2 = delete_min_heap(heap);

        char h_name[10];
        h_name[0] = 'H';
        h_name[1] = '-';
        if (h_count < 10) {
            h_name[2] = '0' + h_count;
            h_name[3] = '\0';
        }
        else {
            h_name[2] = '0' + (h_count / 10);
            h_name[3] = '0' + (h_count % 10);
            h_name[4] = '\0';
        }
        h_count++;

        TreeNode* parent = make_tree(e1.ptree, e2.ptree, h_name, e1.key + e2.key);

        element e;
        e.key = parent->weight;
        e.ptree = parent;

        insert_min_heap(heap, e);
    }

    element final = delete_min_heap(heap);
    return final.ptree;
}

// ===================메인함수======================= //

int main() {
    FILE* file = fopen("huff_A.txt", "r");

    if (file == NULL) {
        printf("오류: huff_A.txt 파일을 찾을 수 없습니다!\n");
        return 1;
    }

    int count = 0;
    fscanf(file, "%d", &count);
    printf("문자 개수? %d\n", count);

    HeapType* heap = create();
    init(heap);
    int total_freq = 0;

    for (int i = 0; i < count; i++) {
        char ch[10];
        int freq;
        fscanf(file, "%s %d", ch, &freq);

        printf("문자? %s\n", ch);
        printf("빈도수? %d\n", freq);

        TreeNode* node = make_tree(NULL, NULL, ch, freq);
        element e;
        e.key = freq;
        e.ptree = node;

        insert_min_heap(heap, e);
        total_freq += freq;
    }
    fclose(file);

    // 허프만 트리 생성+전위순회
    TreeNode* root = huffman_tree(heap, count);

    printf("\n");
    preorder(root);
    printf("\n\n");

    //허프만 비트 수 계산
    int codes[100];
    int huffman_bits = 0;
    print_codes(root, codes, 0, &huffman_bits);

    //고정비트,허프만 비트 수 비교 계산
    int bit_len = fixed_bit(count);
    int fixed_bits = total_freq * bit_len;

    printf("\n%d-비트 코드 시: %d bits\n", bit_len, fixed_bits);
    printf("허프만 코드 시: %d bits\n\n", huffman_bits);

    char str1[200];
    char code1[1000];
    char code2[1000];
    char str2[200];

    // 인코딩
    printf("문자열? ");
    scanf("%s", str1);

    encode_string(root, str1, code1);
    printf("코드열: %s\n\n", code1);

    // 디코딩
    printf("코드열? ");
    scanf("%s", code2);

    decode_string(root, code2, str2);
    printf("문자열: %s\n", str2);

    destroy_tree(root);
    free(heap);

    return 0;
}