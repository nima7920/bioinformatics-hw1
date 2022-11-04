# Bioinformatics- Homework 1

This homework contains 4 problems:

## **Problem 1: Computing GC Content**

The GC-content of a DNA string is given by the percentage of symbols in the string that are 'C' or 'G'. For example, the GC-content of "AGCTATAG" is 37.5%.

**Given:** At most 10 DNA strings (of length at most 1 kbp each).

**Return:** The ID of the string having the highest GC-content, followed by the GC-content of that string.

**Sample Dataset**
```
>Rosalind_6404
CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCC
TCCCACTAATAATTCTGAGG
>Rosalind_5959
CCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAGGCGCTCCGCCGAAGGTCT
ATATCCATTTGTCAGCAGACACGC
>Rosalind_0808
CCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGAC
TGGGAACCTGCGGGCAGTAGGTGGAAT
```
**Sample Output**
```
Rosalind_0808
60.919540
```

## **Problem 2: Complementing a Strand of DNA**

In DNA strings, symbols 'A' and 'T' are complements of each other, as are 'C' and 'G'.

The reverse complement of a DNA string $s$ is the string $s'$ formed by reversing the symbols of $s$, then taking the complement of each symbol (e.g., the reverse complement of "GTCA" is "TGAC").

**Given:** A DNA string $s$ of length at most 1000 bp.

**Return:** The reverse complement $s'$ of $s$.

**Sample Dataset**
```
AAAACCCGGT
```
**Sample Output**
```
ACCGGGTTTT
```

## **Problem 3: Enumerating k-mers Lexicographically**

**Given:** A collection of at most 10 symbols defining an ordered alphabet, and a positive integer $n$( $n \leq 10$).

**Return:** All strings of length $n$ that can be formed from the alphabet, ordered lexicographically (use the standard order of symbols in the English alphabet).

**Sample Dataset**
```
A C G T
2
```
**Sample Output**
```
AA
AC
AG
AT
CA
CC
CG
CT
GA
GC
GG
GT
TA
TC
TG
TT
```

## **Problem 4: Construct a Trie from a Collection of Patterns**

Reads will form a collection of strings Patterns that we wish to match against a reference genome Text. For each string in Patterns, we will first find all its exact matches as a substring of Text (or conclude that it does not appear in Text). When hunting for the cause of a genetic disorder, we can immediately eliminate from consideration areas of the reference genome where exact matches occur. We will later generalize this problem to find approximate matches, where single nucleotide substitutions in reads separate the individual from the reference genome (or represent errors in reads).

**Multiple Pattern Matching Problem:** Find all occurrences of a collection of patterns in a text.
     **Input:** A string Text and a collection Patterns containing (shorter) strings.
     **Output:** All starting positions in Text where a string from Patterns appears as a substring.

To solve this problem, we will consolidate Patterns into a directed tree called a trie (pronounced “try”), which is written Trie(Patterns) and has the following properties.

The trie has a single root node with indegree 0, denoted root.
Each edge of Trie(Patterns) is labeled with a letter of the alphabet.
Edges leading out of a given node have distinct labels.
Every string in Patterns is spelled out by concatenating the letters along some path from the root downward.
Every path from the root to a leaf, or node with outdegree 0, spells a string from Patterns.
The most obvious way to construct Trie(Patterns) is by iteratively adding each string from Patterns to the growing trie, as implemented by the following algorithm.
```
    TRIECONSTRUCTION(Patterns)
        Trie ← a graph consisting of a single node root
        for each string Pattern in Patterns
            currentNode ← root
            for i ← 1 to |Pattern|
                if there is an outgoing edge from currentNode with label currentSymbol
                    currentNode ← ending node of this edge
                else
                    add a new node newNode to Trie
                    add a new edge from currentNode to newNode with label currentSymbol
                    currentNode ← newNode
        return Trie
```
### **Trie Construction Problem**
Construct a trie on a collection of patterns.

**Given:** A collection of strings Patterns.

**Return:** The adjacency list corresponding to Trie(Patterns), in the following format. If Trie(Patterns) has n nodes, first label the root with 1 and then label the remaining nodes with the integers 2 through n in any order you like. Each edge of the adjacency list of Trie(Patterns) will be encoded by a triple: the first two members of the triple must be the integers labeling the initial and terminal nodes of the edge, respectively; the third member of the triple must be the symbol labeling the edge.

**Sample Dataset**
```
ATAGA
ATC
GAT
```
**Sample Output**
```
0->1:A
1->2:T
2->3:A
3->4:G
4->5:A
2->6:C
0->7:G
7->8:A
8->9:T
```
