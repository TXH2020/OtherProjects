package programs;
import java.util.*;
public class Gale_Shapely {
	
int checkfree(boolean f[]) {
	for(int i=0;i<f.length;i++)
		if(f[i])
			return i;
	return -1;
}

int check_index(String f[],String key) {
	for(int i=0;i<f.length;i++)
		if(f[i].equals(key))
			return i;
	return -1;
}

void display(String a[],String w[]) {
	for(int i=0;i<a.length;i++)
		System.out.println(a[i]+","+w[i]);
}

void gs(String mpl[][],String wpl[][],String m[],String w[]) {
	boolean freem[]=new boolean[m.length];
	boolean not_proposed[][]=new boolean[m.length][m.length];
	String curr_par[]=new String[m.length];
	for(int i=0;i<m.length;i++) {
		freem[i]=true;
		curr_par[i]=null;
		for(int j=0;j<m.length;j++)
			not_proposed[i][j]=true;}
	while(true) {
		int s=checkfree(freem);
		if(s==-1)
			break;
		int d=checkfree(not_proposed[s]);
		String p=mpl[s][d];
		not_proposed[s][d]=false;
		int k=check_index(w,p);
		if(curr_par[k]==null) {	
				freem[s]=false;
				curr_par[k]=m[s];}
			else {
				if(check_index(wpl[k],m[s])<check_index(wpl[k],curr_par[k])) {
					freem[s]=false;
					freem[check_index(m,curr_par[k])]=true;
					curr_par[k]=m[s];}
				else 
					continue;}}
	display(curr_par,w);
}
public static void main(String args[]) {
	Scanner in=new Scanner(System.in);
	System.out.println("enter no. of men and women");
	int n=in.nextInt();
	String m[]=new String[n];
	String w[]=new String[n];
	for(int i=0;i<n;i++) {
		System.out.println("enter name of man"+(i+1));
		m[i]=in.next();
	}
	for(int i=0;i<n;i++) {
		System.out.println("enter name of woman"+(i+1));
		w[i]=in.next();
	}
	String men[][]=new String[n][n];
	String women[][]=new String[n][n];
	for(int i=0;i<n;i++) {
		System.out.println("Enter preference list of man "+m[i]+" in nos.");
		for(int j=0;j<n;j++)
			men[i][j]=in.next();
	}
	for(int i=0;i<n;i++) {
		System.out.println("Enter prefernce list of woman "+w[i]+" in nos.");
		for(int j=0;j<n;j++)
			women[i][j]=in.next();
	}
	Gale_Shapely o=new Gale_Shapely();
	o.gs(men, women,m,w);
}
}