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


## **Problem 4: Construct a Trie from a Collection of Patterns**

