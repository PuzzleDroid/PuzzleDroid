
import React from 'react';
import ComponentCreator from '@docusaurus/ComponentCreator';
export default [
{
  path: '/PuzzleDroid/',
  component: ComponentCreator('/PuzzleDroid/','c2c'),
  exact: true,
},
{
  path: '/PuzzleDroid/__docusaurus/debug',
  component: ComponentCreator('/PuzzleDroid/__docusaurus/debug','5e2'),
  exact: true,
},
{
  path: '/PuzzleDroid/blog',
  component: ComponentCreator('/PuzzleDroid/blog','b1c'),
  exact: true,
},
{
  path: '/PuzzleDroid/blog/hello-world',
  component: ComponentCreator('/PuzzleDroid/blog/hello-world','82d'),
  exact: true,
},
{
  path: '/PuzzleDroid/blog/hola',
  component: ComponentCreator('/PuzzleDroid/blog/hola','3c0'),
  exact: true,
},
{
  path: '/PuzzleDroid/blog/tags',
  component: ComponentCreator('/PuzzleDroid/blog/tags','fdf'),
  exact: true,
},
{
  path: '/PuzzleDroid/blog/tags/docusaurus',
  component: ComponentCreator('/PuzzleDroid/blog/tags/docusaurus','385'),
  exact: true,
},
{
  path: '/PuzzleDroid/blog/tags/facebook',
  component: ComponentCreator('/PuzzleDroid/blog/tags/facebook','845'),
  exact: true,
},
{
  path: '/PuzzleDroid/blog/tags/hello',
  component: ComponentCreator('/PuzzleDroid/blog/tags/hello','825'),
  exact: true,
},
{
  path: '/PuzzleDroid/blog/tags/hola',
  component: ComponentCreator('/PuzzleDroid/blog/tags/hola','16d'),
  exact: true,
},
{
  path: '/PuzzleDroid/blog/welcome',
  component: ComponentCreator('/PuzzleDroid/blog/welcome','d2a'),
  exact: true,
},
{
  path: '/PuzzleDroid/docs',
  component: ComponentCreator('/PuzzleDroid/docs','1fb'),
  
  routes: [
{
  path: '/PuzzleDroid/docs/',
  component: ComponentCreator('/PuzzleDroid/docs/','f72'),
  exact: true,
},
{
  path: '/PuzzleDroid/docs/doc2',
  component: ComponentCreator('/PuzzleDroid/docs/doc2','1b2'),
  exact: true,
},
{
  path: '/PuzzleDroid/docs/mdx',
  component: ComponentCreator('/PuzzleDroid/docs/mdx','345'),
  exact: true,
},
]
},
{
  path: '*',
  component: ComponentCreator('*')
}
];
