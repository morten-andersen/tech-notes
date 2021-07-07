### Git commands

#### clear all local branches except master and current

`git branch | egrep -v "(master|\*)" | xargs git branch -D`

#### git stash

* git stash list: `git stash list`
* git stash show diff: `git stash show -p stash@{0}`
* git stash drop: `git stash drop stash@{0}`

#### git diff

* git diff unpushed changes: `git diff origin/<branch>`

#### undo last local commit

* *soft* - keeping local changes: `git reset --soft HEAD~1`
* *hard* - discard local changes: `git reset --hard HEAD~1`

#### revert a single commit

* `git revert <sha>`

#### git relocate remote

* `git remote set-url origin <remote url>`

#### updating from a cloned/forked repository

* [Updating Cloned/Forked Repository On Local Machine and GitHub!](https://avilpage.com/2014/11/git-updating-clonedforked-repository-on.html)

#### execute git in subfolder

* `git -C <folder> <command>`

#### helper function for working with multiple repositories in subfolders

Insert in `~/.bash_aliases`

```bash
# command for executing a git command in all git sub folders
# usage:
#   git-sub status           show git status
#   git-sub fetch origin     fetch origin information
#   git-sub branch           show branches (local)
#
# use -i as first argument for interactive mode

git-sub () {
  interactive=''
  if [ "$1" == "-i" ]
  then
    shift
    interactive='-p'
  fi
  if [ $# -eq 0 ]
  then
    echo "usage: git-sub <git commands>"
    echo "       use '-i' as first arugment for interactive mode"
    return 1
  fi

  find . -maxdepth 3 -name .git -type d | rev | cut -c 6- | rev | xargs $interactive -I {} sh -c "echo '\n\033[1;32m{}\033[0m' && git -C {} $@"
}
```
