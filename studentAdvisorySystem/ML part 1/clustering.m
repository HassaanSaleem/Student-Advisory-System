data=csvread('V1.csv');

X=data(503:649,1:19);

K = 4;
max_iters = 40;

centroids = zeros(K,size(X,2)); 
randidx = randperm(size(X,1));
centroids = X(randidx(1:K), :);
initial_centroids=centroids;

% Run K-Means algorithm. The 'true' at the end tells our function to plot
% the progress of K-Means
[centroids, idx] = runkMeans(X,initial_centroids,max_iters,true);
fprintf('\nK-Means Done.\n\n');

idx;