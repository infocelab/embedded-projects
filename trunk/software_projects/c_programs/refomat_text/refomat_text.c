// Name: Reformat text
// Description:Reformat text to fit into given columns. Read an ASCII file containing text ad write an other file with reformatted text (Left justify).

#include <stdio.h>
#include <malloc.h>
#include <string.h>
/*--------------------------------------------------------*/
#define MAXFLNAMELEN 260
#define MAXSIZEDATA 512
#define NMINCOLS 26
#define NDEFCOLS 60
#define NMAXCOLS 255
/*--------------------------------------------------------*/
typedef struct slist 
{
    struct slist *sx;
    struct slist *dx;
    int len;
    char data[MAXSIZEDATA];
} 
tslist;
/*--------------------------------------------------------*/
static char *preadonly = "rb";
static char *pwriteonly = "wt";
static tslist *h_l; // head pointer of linked list
static tslist *i_l; // insert pointer
static tslist *a_l; // actual pointer
static unsigned char buf[MAXSIZEDATA];
static unsigned char big[MAXSIZEDATA*2];
/*--------------------------------------------------------*/
int init_l()
{
    h_l = a_l = i_l = NULL;
    h_l = (tslist *)malloc(sizeof(*h_l));
    if (h_l!=NULL) 
    {
        h_l->sx = h_l;
        h_l->dx = h_l;
        h_l->len = 0;
        return(1);
    }
    return(0);
}

int insr_l(len,buf)
int len;
char *buf;
{
    i_l = (tslist *)malloc(sizeof(*h_l));
    if (i_l!=NULL) 
    {
        i_l->sx = h_l->sx;
        i_l->dx = h_l;
        i_l->len = len;
        memcpy(i_l->data,buf,len);
        h_l->sx->dx = i_l;
        h_l->sx = i_l;
        return(1);
    }
    return(0);
}

int kill_l()
{
    if (h_l!=NULL) 
    {
        a_l = h_l->dx;
        while (a_l != h_l) 
        {
            i_l = a_l;
            a_l = a_l->dx;
            free(i_l);
        }
        free(h_l);
    }
    h_l = a_l = i_l = NULL;
    return(0);
}

int gets_l(len,buf)
int *len;
char *buf;
{
    if (a_l==h_l) return(0);
    if (a_l==NULL) a_l = h_l->dx;
    else a_l = a_l->dx;
    if (a_l==h_l) return(0);
    else 
    {
        *len = a_l->len;
        memcpy(buf,a_l->data,*len);
        return(1);
    }
}
int get1block(len,buf)
int *len;
char *buf;
{
    int n;
    if ((*len)>MAXSIZEDATA)
    return(*len);
    if (gets_l(&n,&buf[*len]))
    (*len) += n;
    if ((*len)<=MAXSIZEDATA)
    if (gets_l(&n,&buf[*len]))
    (*len) += n;
    return(*len);
}

int concat1car(dst,src)
char *dst;
char src;
{
    int i;
    i = strlen(dst);
    dst[i+1] = 0;
    dst[i] = src;
    return(i+1);
}

int ldelete(len,s,i,j)
int len;
char *s;
int i; // start position begin with 1 
int j; // number of char to remove
{
    int x,n,m,k;
    k = i-1;
    n = i+j-1;
    m = len;
    for (x = n; x <= m; x++) s[k++] = s[x];
    return(j);
}

int get1token(len,src,dst)
int *len;
char *src;
char *dst;
{
    int n = 0;
    char *pc;
    pc = src;
    dst[0] = 0;
    while (isspace(*pc)) 
    {
        pc++;
        n++;
        if (n>=(*len)) break;
    }
    if (!(n>=(*len)))
    while (!isspace(*pc)) 
    {
        concat1car(dst,*pc);
        pc++;
        n++;
        if (n>=(*len)) break;
    }
    if (n>0) 
    {
        ldelete(*len,src,1,n);
        *len -= n;
    }
    return(dst[0]);
}
/*--------------------------------------------------------*/
int output_row(fo,riga)
FILE *fo;
char *riga;
{
    return(fprintf(fo,"%s\n",riga));
}
/*--------------------------------------------------------*/
int write_formatted(ncols,fo)
int ncols;
FILE *fo;
{
    int len = 0;
    int follow;
    char token[80];
    buf[0] = 0;
    while (get1block(&len,big)) 
    { 
        if (!get1token(&len,big,token)) 
        {
            if (buf[0]!=0)
            output_row(fo,buf);
            break;
        }
        follow = (strlen(buf)+strlen(token)+1)<=ncols;
        if (follow) 
        {
            if (buf[0]!=0)
            concat1car(buf,' ');
            strcat(buf,token);
            switch (token[strlen(token)-1])
            {
                 case '.' : if (big[0]=='\r' || big[0]=='\n') 
                 {
                      output_row(fo,buf);
                      buf[0] = 0;
                 }
                    break;
            }
        }
        else 
        {
             output_row(fo,buf);
             strcpy(buf,token);
        }
    }
    return(0);
}
int reformat()
{
    FILE *fi;
    FILE *fo;
    char nomei[MAXFLNAMELEN];
    char nomeo[MAXFLNAMELEN];
    char snum[20];
    int ncols,len;
    fi = fo = NULL; /* azzera descrittori file */
    printf("\nInput file name ? ");
    fgets(nomei,sizeof(nomei),stdin);
    if (nomei[strlen(nomei)-1]=='\n')
    nomei[strlen(nomei)-1] = 0;
    if (nomei[0]==0) return(0);
    fi = fopen(nomei,preadonly);
    if (fi==NULL) 
    {
        printf("\nError opening input file %s\n",nomei);
        return(1);
    }
    printf("\nOutput file name ? ");
    fgets(nomeo,sizeof(nomeo),stdin);
    if (nomeo[strlen(nomeo)-1]=='\n')
    nomeo[strlen(nomeo)-1] = 0;
    if (nomeo[0]==0) 
    {
        if (fi!=NULL) fclose(fi);
        return(0);
    }
    fo = fopen(nomeo,pwriteonly);
    if (fo==NULL) 
    {
        printf("\nError opening output file %s\n",nomeo);
        if (fi!=NULL) fclose(fi);
        return(1);
    }
    if (!init_l()) 
    {
        printf("\nInsufficient memory!");
        if (fi!=NULL) fclose(fi);
        if (fo!=NULL) fclose(fo);
        return(1);
    }
    while ((len = fread(buf,1,sizeof(buf),fi)) != 0)
    if (!insr_l(len,buf)) 
    {
        printf("\nFile too big!");
        if (fi!=NULL) fclose(fi);
        if (fo!=NULL) fclose(fo);
        return(1);
    }
    printf("\nNumber of cols (%d..%d) [%d] ? ",NMINCOLS,NMAXCOLS,NDEFCOLS);
    fgets(snum,sizeof(snum),stdin);
    if (snum[strlen(snum)-1]=='\n')
    snum[strlen(snum)-1] = 0;
    if (snum[0]==0) ncols = NDEFCOLS;
    else 
    {
        ncols = atoi(snum);
        if (ncols<NMINCOLS) ncols = NMINCOLS;
        if (ncols>NMAXCOLS) ncols = NMAXCOLS;
    }
    write_formatted(ncols,fo);
    if (fi!=NULL) fclose(fi);
    if (fo!=NULL) fclose(fo);
    kill_l();
    return(0);
}
/*--------------------------------------------------------*/
int main()
{
    printf("\nREFORMAT \n");
    return(reformat());
}
/*--------------------------------------------------------*/

	
		
