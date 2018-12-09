data=csvread('V3.csv');

X=data(2:502,1:21);

Y=data(2:502,22);

m=length(Y);

X=[ones(m,1) X];

Theta=pinv(X'*X)*X'*Y;

gp=length(data(503:end,1));

j=1;

for i=503:645

    test=data(i,1:21);

    test=[ones(1,1) test];

    gp(j)=dot(Theta,test);
    j++;

endfor
gp=gp'

save sgpa4.csv gp;