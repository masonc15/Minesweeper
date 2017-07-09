#include	<stdio.h>
struct	{
		char	x;
		long	long	y;
}	a;
union	{
		char	x;
		long long	y;
}	b;
char	buf[100];
int	main()
{
		char	*p	=	buf;
		printf("sizeof(a)=%d\n",	sizeof(a));
		printf("sizeof(b)=%d\n",	sizeof(b));
		printf("sizeof(buf)=%d\n",	sizeof(buf));
		printf("sizeof(p)=%d\n",	sizeof(p));
		return	0;
}