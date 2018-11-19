function centroids=computeCentroids(X,idx,K)

[m n]=size(X);

centroids=zeros(K, n);

count=zeros(K,1);
for x=1:m,
  for y=1:K, 
    if idx(x)==y,
      centroids(y,:)=(centroids(y,:)+ X(x,:));
      count(y)=count(y)+1;
    end
  end
end  
centroids=centroids./count;

end

