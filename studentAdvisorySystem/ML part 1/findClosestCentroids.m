function idx=findClosestCentroids(X, centroids)

K=size(centroids, 1);

idx=zeros(size(X,1), 1);

m=size(X,1);
for x=1:m,
  minDist=10^6; 
  for y=1:K,
    dist=sum((X(x,:)-centroids(y,:)).^2);
    if dist<minDist,
      minDist=dist;
      idx(x)=y;
    end
  end
end  

end

