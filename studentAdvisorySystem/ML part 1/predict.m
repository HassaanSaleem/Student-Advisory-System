data=csvread('V1.csv');

X=data(2:601,1:19);

Y=data(2:601,20);

m=length(Y);

X=[ones(m,1) X];

Theta=pinv(X'*X)*X'*Y;

gp=length(data(602:end,1));

j=1;

for i=602:650

    test=data(i,1:19);

    test=[ones(1,1) test];

    gp(j)=dot(Theta,test);
    j++;

endfor

gp=gp';

Ytest=data(602:end,20);

RMSE=(sqrt(sum((Ytest-gp).^2))/length(Ytest))

SQER=(sum((Ytest-gp).^2))/(2*length(Ytest))