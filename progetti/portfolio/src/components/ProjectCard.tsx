import React from 'react';
import { Project } from './ProjectsSection';

interface ProjectCardProps {
  project: Project;
  isHovered: boolean;
  onHover: () => void;
  onLeave: () => void;
}

const ProjectCard: React.FC<ProjectCardProps> = ({ 
  project, 
  isHovered,
  onHover,
  onLeave
}) => {
  return (
    <div 
      className={`bg-white dark:bg-gray-900 rounded-lg shadow-md overflow-hidden transition-all duration-300 ${
        isHovered ? 'transform -translate-y-2 shadow-lg' : ''
      }`}
      onMouseEnter={onHover}
      onMouseLeave={onLeave}
    >
      <div className="p-6">
        <div className="flex items-start gap-4">
          <div className="flex-shrink-0 bg-teal-50 dark:bg-teal-900/30 p-3 rounded-lg">
            {project.icon}
          </div>
          <div>
            <div className="flex items-center">
              <span className="text-xs font-medium text-teal-600 dark:text-teal-400 bg-teal-50 dark:bg-teal-900/30 py-1 px-2 rounded">
                {project.period}
              </span>
            </div>
            <h3 className="text-xl font-bold mt-2 text-gray-800 dark:text-white">
              {project.title}
            </h3>
            <p className="text-sm text-gray-500 dark:text-gray-400 mt-1">
              {project.course}
            </p>
          </div>
        </div>

        <p className="mt-4 text-gray-600 dark:text-gray-300">
          {project.description}
        </p>
        
        {project.teammates && (
          <p className="mt-3 text-sm italic text-gray-500 dark:text-gray-400">
            {project.teammates}
          </p>
        )}
        
        <div className="mt-4 flex flex-wrap gap-2">
          {project.tags.map((tag, index) => (
            <span 
              key={index} 
              className="text-xs bg-gray-100 dark:bg-gray-800 text-gray-600 dark:text-gray-300 px-2 py-1 rounded"
            >
              {tag}
            </span>
          ))}
        </div>
      </div>
    </div>
  );
};

export default ProjectCard;