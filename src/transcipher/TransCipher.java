
package transcipher;

public class TransCipher
{  
char arr[][],encrypt[][],decrypt[][],keya[],keytemp[];
public void creatematrixE(String s,String key,int row,int column)
{
arr=new char[row][column];
int k=0;
keya=key.toCharArray();
for(int i=0;i<row;i++)
{
for(int j=0;j<column;j++)
{
if(k<s.length())
{
arr[i][j]=s.charAt(k);
k++;
}
else
{
arr[i][j]=' ';
}
}
}
}
public void createkey(String key,int column)
{
keytemp=key.toCharArray();
for(int i=0;i<column-1;i++)
{
for(int j=i+1;j<column;j++)
{
if(keytemp[i]>keytemp[j])
{
char temp=keytemp[i];
keytemp[i]=keytemp[j];
keytemp[j]=temp;
}
}
}
}
public void creatematrixD(String s,String key,int row,int column)
{
arr=new char[row][column];
int k=0;
keya=key.toCharArray();
for(int i=0;i<column;i++)
{
for(int j=0;j<row;j++)
{
if(k<s.length())
{
arr[j][i]=s.charAt(k);
k++;
}
else
{
arr[j][i]=' ';
}
}
}
}
public void encrypt(int row,int column)
{
encrypt=new char[row][column];
for(int i=0;i<column;i++)
{
for(int j=0;j<column;j++)
{
if(keya[i]==keytemp[j])
{
for(int k=0;k<row;k++)
{
encrypt[k][j]=arr[k][i];
}
keytemp[j]='?';
break;
}
}
}
}
public void decrypt(int row,int column)
{
decrypt=new char[row][column];
for(int i=0;i<column;i++)
{
for(int j=0;j<column;j++)
{
if(keya[j]==keytemp[i])
{
for(int k=0;k<row;k++)
{
decrypt[k][j]=arr[k][i];
}
keya[j]='?';
break;
}
}
}
}
public String resultE(int row,int column,char arr[][])
{char[] encrypted = new char[100];
int k=0;

for(int i=0;i<column;i++)
{
for(int j=0;j<row;j++)
{
encrypted[k]=arr[j][i];
k++;
}
}
return new String(encrypted);
}
public String resultD(int row,int column,char arr[][])
{int k=0;
char[] decrypted = new char[100];
for(int i=0;i<row;i++)
{
for(int j=0;j<column;j++)
{
decrypted[k]=arr[i][j];
k++;
}
}
return new String(decrypted);
}
}
