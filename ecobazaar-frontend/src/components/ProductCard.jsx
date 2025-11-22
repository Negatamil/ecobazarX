import React from 'react';
import { motion } from 'framer-motion';
import { Card, CardContent, CardFooter } from './ui/Card';
import { Button } from './ui/Button';
import { Leaf, Zap, Droplets } from 'lucide-react';

const ProductCard = ({ product, onAddToCart, onViewDetails }) => {
  const carbonFootprint = product.carbonFootprint || {};
  
  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.3 }}
      whileHover={{ y: -5 }}
      className="group"
    >
      <Card className="overflow-hidden hover:shadow-xl transition-all duration-300 border-0 bg-white/80 backdrop-blur-sm">
        <div className="relative overflow-hidden">
          <img
            src={product.imageUrl || `https://picsum.photos/400/300?random=${product.productId}`}
            alt={product.name}
            className="w-full h-48 object-cover transition-transform duration-300 group-hover:scale-105"
          />
          <div className="absolute top-3 right-3">
            <div className="bg-eco-500 text-white px-2 py-1 rounded-full text-xs font-medium flex items-center gap-1">
              <Leaf className="w-3 h-3" />
              Eco-Friendly
            </div>
          </div>
        </div>
        
        <CardContent className="p-4">
          <h3 className="font-semibold text-lg mb-2 text-gray-800">{product.name}</h3>
          <p className="text-gray-600 text-sm mb-3 line-clamp-2">{product.description}</p>
          
          <div className="flex justify-between items-center mb-3">
            <span className="text-2xl font-bold text-eco-600">${product.price}</span>
            <span className="text-sm text-gray-500">by {product.vendor?.name || 'EcoVendor'}</span>
          </div>
          
          {/* Carbon Footprint Info */}
          <div className="grid grid-cols-3 gap-2 mb-4">
            <div className="text-center p-2 bg-eco-50 rounded-lg">
              <Leaf className="w-4 h-4 text-eco-500 mx-auto mb-1" />
              <div className="text-xs text-gray-600">CO₂</div>
              <div className="text-sm font-medium">{carbonFootprint.co2Emission || '2.1'}kg</div>
            </div>
            <div className="text-center p-2 bg-blue-50 rounded-lg">
              <Zap className="w-4 h-4 text-blue-500 mx-auto mb-1" />
              <div className="text-xs text-gray-600">Energy</div>
              <div className="text-sm font-medium">{carbonFootprint.energyUsed || '15'}kWh</div>
            </div>
            <div className="text-center p-2 bg-cyan-50 rounded-lg">
              <Droplets className="w-4 h-4 text-cyan-500 mx-auto mb-1" />
              <div className="text-xs text-gray-600">Water</div>
              <div className="text-sm font-medium">{carbonFootprint.waterUsed || '100'}L</div>
            </div>
          </div>
        </CardContent>
        
        <CardFooter className="p-4 pt-0 flex gap-2">
          <Button 
            variant="outline" 
            size="sm" 
            className="flex-1"
            onClick={() => onViewDetails(product)}
          >
            View Details
          </Button>
          <Button 
            variant="eco" 
            size="sm" 
            className="flex-1"
            onClick={() => onAddToCart(product)}
          >
            Add to Cart
          </Button>
        </CardFooter>
      </Card>
    </motion.div>
  );
};

export default ProductCard;