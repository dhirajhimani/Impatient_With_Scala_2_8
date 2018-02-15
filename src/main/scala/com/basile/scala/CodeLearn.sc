val arr = List(1,2,3,4,5)

(for(i<- (arr.size - 1).to(0).by(-1)) yield arr(i))